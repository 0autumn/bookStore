package app.store.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import java.util.Map;

import app.store.model.entity.Product;
import app.store.model.entity.Spec;

public class SpecServiceImpl extends ServiceSupport<Spec> implements SpecService {

	@Override  
	public List<Spec> getaSpec(long productId) {
	
		return this.getDao().findBy("product.id",productId);
		
	}
    
	public List<Map<String,Object>> getSpecs(long productId){
		List<Spec> list=new ArrayList<>();
		List<Map<String,Object>> list1=new ArrayList<>();
		list=getaSpec(productId);
		for (int i = 0; i < list.size(); i++) {
		  Map<String,Object> map=new HashMap<String, Object>();
		  map.put("specName",list.get(i));
		  map.put("specValue",list.get(i).getSpecInfos());
		  list1.add(map);
	}
		return list1;
  }

	
}
