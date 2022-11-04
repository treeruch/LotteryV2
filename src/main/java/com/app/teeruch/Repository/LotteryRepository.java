package com.app.teeruch.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.teeruch.model.LotteryModel;
import com.app.teeruch.service.UtilService;

@Repository
public class LotteryRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UtilService utilService;
	

	private static final SimpleDateFormat sdf_ddMMyyyy = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
	
	String startDate = sdf_ddMMyyyy.format(new Date());
	String endDate = sdf_ddMMyyyy.format(new Date());

	
	public LotteryModel findDashboard() {
		LotteryModel obj = new LotteryModel();
		StringBuilder sql = new StringBuilder();
			sql.append(" SELECT SUM(sum_top_three_price) as sum_top_three_price  "
					+" ,SUM(sum_tod_price) as sum_tod_price  "
					+" ,SUM(sum_top_two_price) as sum_top_two_price  "
					+" ,SUM(sum_under_two_price) as sum_under_two_price  "
					+" ,SUM(sum_price)  as sum_price  "
					+" FROM history  "
					+" WHERE FORMAT (create_date, 'yyyy-MM-dd') >= '"+startDate+"'"
					+" AND FORMAT (create_date, 'yyyy-MM-dd') <= '"+endDate+"'");
			
			Query query = entityManager.createNativeQuery(sql.toString());
			
			@SuppressWarnings("unchecked")
			List<Object[]> dataList = query.getResultList();
			
			for(Object[] data : dataList) {
			
			if(data[0] != null) {
				 obj.setSumTopThreePrice(utilService.formatPrice((int) data[0]));
				 obj.setSumTodPrice(utilService.formatPrice((int) data[1]));
				 obj.setSumTopTwoPrice(utilService.formatPrice((int) data[2]));
				 obj.setSumUnderTwoPrice(utilService.formatPrice((int) data[3]));
				 obj.setSumPrice(utilService.formatPrice((int) data[4]));
			} else {
				obj.setSumTopThreePrice("0");
				 obj.setSumTodPrice("0");
				 obj.setSumTopTwoPrice("0");
				 obj.setSumUnderTwoPrice("0");
				 obj.setSumPrice("0");
			}
			
			}
		
		return  obj;
	}
}
