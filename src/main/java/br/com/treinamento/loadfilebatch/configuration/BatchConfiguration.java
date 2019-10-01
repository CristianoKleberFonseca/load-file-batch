package br.com.treinamento.loadfilebatch.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import br.com.treinamento.loadfilebatch.domain.Pulso;
import br.com.treinamento.loadfilebatch.job.JobCompletionNotificationListener;
import br.com.treinamento.loadfilebatch.job.PulsoItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public FlatFileItemReader<Pulso> reader() {
		FlatFileItemReaderBuilder<Pulso> flatFileItemReaderBuilder = new FlatFileItemReaderBuilder<Pulso>();
		
		flatFileItemReaderBuilder.linesToSkip(1);
		flatFileItemReaderBuilder.name("pulsoItemReader");
		flatFileItemReaderBuilder.resource(new ClassPathResource("imports.csv"));
		flatFileItemReaderBuilder.delimited().names(new String[] { "TelematicsID", "DriverReferenceId", "JourneyUUID", "LocalDtmIso", "Latitude",
				"Longitude", "Speed", "dSpeed", "Heading", "dHeading", "Altitude", "dAltitude", "Haccuracy",
				"Vaccuracy", "V2Distance", "V2AvgDuration", "RoadSegmentId", "RSLValidationId", "RSL",
				"RSLDistanceFromRoad", "DistanceFromNonRoadWay" });
		flatFileItemReaderBuilder.fieldSetMapper(new BeanWrapperFieldSetMapper<Pulso>() {
			{
				setTargetType(Pulso.class);
			}
		});
	
		return flatFileItemReaderBuilder.build();
	}

	@Bean
	public PulsoItemProcessor processor() {
		return new PulsoItemProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Pulso> writer(DataSource dataSource) {
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append("INSERT INTO pulso (");
		sqlSB.append("telematics_ID,");
		sqlSB.append("driver_reference_Id,");
		sqlSB.append("journey_UUID,");
		sqlSB.append("local_dtm_iso,");
		sqlSB.append("latitude,");
		sqlSB.append("longitude,");
		sqlSB.append("speed,");
		sqlSB.append("d_speed,heading,");
		sqlSB.append("d_heading,");
		sqlSB.append("altitude,");
		sqlSB.append("d_altitude,");
		sqlSB.append("haccuracy,");
		sqlSB.append("vaccuracy,");
		sqlSB.append("v_2_distance,");
		sqlSB.append("v_2_avg_duration,");
		sqlSB.append("road_segment_Id,");
		sqlSB.append("RSL_validation_Id,");
		sqlSB.append("RSL,");
		sqlSB.append("RSL_distance_from_road,");
		sqlSB.append("distance_from_non_road_way");
		sqlSB.append(") VALUES (");
		sqlSB.append(":id");
		sqlSB.append(", :telematicsID");
		sqlSB.append(", :driverReferenceId");
		sqlSB.append(", :journeyUUID");
		sqlSB.append(", :localDtmIso");
		sqlSB.append(", :latitude");
		sqlSB.append(", :longitude");
		sqlSB.append(", :speed");
		sqlSB.append(", :dSpeed");
		sqlSB.append(", :heading");
		sqlSB.append(", :dHeading");
		sqlSB.append(", :altitude");
		sqlSB.append(", :dAltitude");
		sqlSB.append(", :hacCuracy");
		sqlSB.append(", :vacCuracy");
		sqlSB.append(", :v2Distance");
		sqlSB.append(", :v2AvgDuration");
		sqlSB.append(", :roadSegmentId");
		sqlSB.append(", :rslValidationId");
		sqlSB.append(", :rsl");
		sqlSB.append(", :rslDistanceFromRoad");
		sqlSB.append(", :distanceFromNonRoadWay");
		return new JdbcBatchItemWriterBuilder<Pulso>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql(sqlSB.toString()).dataSource(dataSource).build();
	}
	
	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
		return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener).flow(step1)
				.end().build();
	}

	@Bean
	public Step step1(JdbcBatchItemWriter<Pulso> writer) {
		return stepBuilderFactory.get("step1").<Pulso, Pulso>chunk(15).reader(this.reader()).processor(this.processor())
				.writer(writer).build();
	}

}
