package com.example.ssii.repository;


import com.example.ssii.model.Employe;
import com.example.ssii.model.Mission;
import com.example.ssii.model.Timesheet;
import com.example.ssii.model.TimesheetPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {

	@Query("select DISTINCT m from Mission m join m.timesheets t join t.employe e where e.id=:employeId")
	public List<Mission> findAllMissionByEmployeJPQL(@Param("employeId")int employeId);
	
	@Query("select DISTINCT e from Employe e "
				+ "join e.timesheets t "
				+ "join t.mission m "
				+ "where m.id=:misId")
	public List<Employe> getAllEmployeByMission(@Param("misId")int missionId);
	
	
	@Query("Select t from Timesheet t "
				+ "where t.mission=:mis and "
				+ "t.employe=:emp and "
				+ "t.timesheetPK.dateCreation>=:dateD and "
				+ "t.timesheetPK.dateModification<=:dateF")
	public List<Timesheet> getTimesheetsByMissionAndDate(@Param("emp")Employe employe, @Param("mis")Mission mission, @Param("dateD")Date dateDebut,@Param("dateF")Date dateFin);

	  public Timesheet findBytimesheetPK(TimesheetPK timesheetPK);
}
