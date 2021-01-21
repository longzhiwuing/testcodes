package com.lzwing.demo;

import com.lzwing.demo.dao.UniversitySubjectRankDao;
import com.lzwing.demo.entity.UniversitySubjectRank;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@Slf4j
public class AppTests {

	@Resource
	JdbcTemplate jdbcTemplate;

	@Resource
	private UniversitySubjectRankDao userDao;

	@Test
	public void contextLoads() {


		List<UniversitySubjectRank> universitySubjectRanks = userDao.selectList(null);

		for (UniversitySubjectRank universitySubjectRank : universitySubjectRanks) {
			String univRank = universitySubjectRank.getUnivRank();
			int univLevel = getUnivLevelByUnivRank(univRank);
			universitySubjectRank.setUnivLevel(univLevel);
			int edit = userDao.updateById(universitySubjectRank);

			log.info("edit:{}", edit);
		}


		log.info("done");


		/*String sql = "select * from pe_university_subject_rank";
		List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> data : maps) {
			String rank = (String) data.get("rank");
			Integer id = (Integer) data.get("id");

			String newSql = String.format("update set univ_rank = %s where id=%s", 1, id);

			log.info("newSql:{}", newSql);
		}


		log.info("data:{}", maps);*/
	}

	private int getUnivLevelByUnivRank(String univRank) {
		if (StringUtils.isEmpty(univRank)) {
			return 9;
		}

		if ("A+".equals(univRank)) {
			return 1;
		}

		if ("A".equals(univRank)) {
			return 2;
		}

		if ("A-".equals(univRank)) {
			return 3;
		}

		if ("B+".equals(univRank)) {
			return 4;
		}

		if ("B".equals(univRank)) {
			return 5;
		}

		if ("B-".equals(univRank)) {
			return 6;
		}

		if ("C+".equals(univRank)) {
			return 7;
		}

		if ("C".equals(univRank)) {
			return 8;
		}

		if ("C-".equals(univRank)) {
			return 9;
		}

		return 9;

	}

}
