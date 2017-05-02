package app.store.model.service;

import java.util.List;

import ProductValue.hbm.ProductValueService;
import app.store.model.dao.ProductValueDaoHibenateImpl;
import app.store.model.entity.ProductValue;

public class ProductValueServiceImpl extends  ServiceSupport<ProductValue> implements ProductValueService{

	/*�õ���������Ʒ������
	 * (non-Javadoc)
	 * @see ProductValue.hbm.ProductValueService#getProductAttribute(long)
	 * 
	 */
	@Override
	public List<ProductValue> getProductAttribute(long specinfoId) {
		
		return  this.getDao().findBy("spec.id",specinfoId);
	}
 
	
}
