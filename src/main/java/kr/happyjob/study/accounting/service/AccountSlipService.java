package kr.happyjob.study.accounting.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.accounting.model.AccountSlipModel;
import kr.happyjob.study.accounting.model.DetileAccountListModel;
import kr.happyjob.study.accounting.model.MidProductListModel;
import kr.happyjob.study.accounting.model.ProductListModel;
import kr.happyjob.study.business.model.BizPartnerModel;

public interface AccountSlipService {

	/** 회계전표 목록 조회 */
	public List<AccountSlipModel> accountSlipList(Map<String, Object> paramMap) throws Exception;
	
	/** 회계전표 목록 카운트 조회 */
	public int accountSlipListTotalCnt(Map<String, Object> paramMap) throws Exception;
	
	/** 거래처리스트 */
	public List<BizPartnerModel> clientlist(Map<String, Object> paramMap) throws Exception;
	
	/** 계정과목리스트 */
	public List<DetileAccountListModel> detileAccountList(Map<String, Object> paramMap) throws Exception;

	/** 제품리스트  */
	public List<ProductListModel> productList(Map<String, Object> paramMap) throws Exception;

	/** 제품중분류 목록 */
	public List<MidProductListModel> midProductList(Map<String, Object> paramMap) throws Exception;

	/** 공지사항 단건 조회 */
//	public AccountSlipModel detailone(Map<String, Object> paramMap) throws Exception;
	
}
