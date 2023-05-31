package org.reed.define;

import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.services.InstanceIdGenerator;
import de.codecentric.boot.admin.server.services.InstanceRegistry;

public class ReedRegistry extends InstanceRegistry {
    private final InstanceRepository repository;
    private final InstanceIdGenerator generator;

    public ReedRegistry(InstanceRepository repository, InstanceIdGenerator generator) {
        super(repository, generator);
        this.repository = repository;
        this.generator = generator;
    }

    // @Override
    // public Mono<InstanceId> register(Registration registration) {
    // Assert.notNull(registration, "'registration' must not be null");
    // InstanceId id = generator.generateId(registration);
    // Assert.notNull(id, "'id' must not be null");
    // return repository.compute(id, (key, instance) -> {
    // if (instance == null) {
    // instance = Instance.create(key);
    // }
    // return Mono.just(instance.register(registration));
    // }).map(Instance::getId);
    // }
}
