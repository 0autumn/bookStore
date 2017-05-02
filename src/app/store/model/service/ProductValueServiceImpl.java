package app.store.model.service;

import java.util.List;

import ProductValue.hbm.ProductValueService;
import app.store.model.dao.ProductValueDaoHibenateImpl;
import app.store.model.entity.ProductValue;

public class ProductValueServiceImpl extends  ServiceSupport<ProductValue> implements ProductValueService{


	/*µÃµ½¶©µ¥ÖÐÉÌÆ·µÄÊôÐÔ
	 * (non-Javadoc)
	 * @see ProductValue.hbm.ProductValueService#getProductAttribute(long)
	 * 
	 */
	@Override
	public List<ProductValue> getProductAttribute(long specinfoId) {
		
		return  this.getDao().findBy("spec.id",specinfoId);
	}
 
	public ProductValue getAttribute(long specinfoId,long categoryId){
		ProductValueDaoHibenateImpl pdh=new ProductValueDaoHibenateImpl();
		return pdh.find("category", specinfoId, categoryId);
	}

	/*ï¿½Ãµï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Æ·ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	 * (non-Javadoc)
	 * @see ProductValue.hbm.ProductValueService#getProductAttribute(long)
	 * 
	 */
	
	

}
