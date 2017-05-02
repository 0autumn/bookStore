package app.store.model.service;

import java.util.List;

import app.store.model.entity.Spec;

public interface SpecService {
	 List<Spec> getaSpec(long productId);
}
