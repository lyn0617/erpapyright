package kr.happyjob.study.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.system.dao.DeptMgrDao;
import kr.happyjob.study.system.model.DeptMgrModel;

@Service
public class DeptMgrServiceImpl implements DeptMgrService {
	
	@Autowired
	DeptMgrDao deptMgrDao;
	
	/** 부서 목록 조회 */
	public List<DeptMgrModel> deptlist(Map<String, Object> paramMap) throws Exception{
		
		return deptMgrDao.deptlist(paramMap);
		
	}
	
	/** 부서 목록 카운트 조회 */
	public int countdeptlist(Map<String, Object> paramMap) throws Exception{
		
		return deptMgrDao.countdeptlist(paramMap);
	}
	
	/** 부서 저장 */
	public int deptnewsave(Map<String, Object> paramMap) throws Exception{
		
		return deptMgrDao.deptnewsave(paramMap);
	}
	
	/** 부서 수정 */
	public int deptnewupdate(Map<String, Object> paramMap) throws Exception{
		
		return deptMgrDao.deptnewupdate(paramMap);
	}
	
	/** 부서 삭제 */
	public int deptnewdelete(Map<String, Object> paramMap) throws Exception{
		
		return deptMgrDao.deptnewdelete(paramMap);
	}
	
	/** 부서 상세 조회 */
	public DeptMgrModel detaildept(Map<String, Object> paramMap) throws Exception {
		return deptMgrDao.detaildept(paramMap);
	}
	
	/** 부서 인원 카운트 조회 */
	public int countindept(Map<String, Object> paramMap) throws Exception {
		
		return deptMgrDao.countindept(paramMap);
	}
	
	/** 부서명 중복체크*/
	public int check_dept(DeptMgrModel model) throws Exception {
		int result = deptMgrDao.check_dept(model);
		return result;
		
	}	

}
