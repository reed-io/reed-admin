package org.reed.define;

import java.util.List;

import org.reactivestreams.Subscriber;

import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.values.InstanceId;
import de.codecentric.boot.admin.server.eventstore.InstanceEventStore;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReedEventStore implements InstanceEventStore{

	@Override
	public void subscribe(Subscriber<? super InstanceEvent> s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Flux<InstanceEvent> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<InstanceEvent> find(InstanceId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> append(List<InstanceEvent> events) {
		// TODO Auto-generated method stub
		return null;
	}

}
