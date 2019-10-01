package br.com.treinamento.loadfilebatch.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import br.com.treinamento.loadfilebatch.domain.Pulso;

public class PulsoItemProcessor implements ItemProcessor<Pulso, Pulso> {
	private static final Logger log = LoggerFactory.getLogger(Pulso.class);

	@Override
	public Pulso process(final Pulso pulso) throws Exception {
		log.info(pulso.toString());
		
		return pulso;
	}
}
