package com.example.ssii.repository;



import com.example.ssii.model.Employe;
import com.example.ssii.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

	@Query("SELECT count(*) FROM Employe")
	public int countemp();

	@Query("SELECT nom FROM Employe")
	public List<String> employeNames();

	@Query("Select " + "DISTINCT emp from Employe emp " + "join emp.departements dps " + "join dps.entreprise entrep "
			+ "where entrep=:entreprise")
	public List<Employe> getAllEmployeByEntreprisec(@Param("entreprise") Entreprise entreprise);

	@Modifying
	@Transactional
	@Query("UPDATE Employe e SET e.email=:email1 where e.id=:employeId")
	public void mettreAjourEmailByEmployeIdJPQL(@Param("email1") String email, @Param("employeId") int employeId);

	@Modifying
	@Transactional
	@Query("DELETE from Contrat")
	public void deleteAllContratJPQL();

	@Query("select c.salaire from Contrat c join c.employe e where e.id=:employeId")
	public float getSalaireByEmployeIdJPQL(@Param("employeId") int employeId);

	@Query("Select " + "DISTINCT AVG(cont.salaire) from Contrat cont " + "join cont.employe emp "
			+ "join emp.departements deps " + "where deps.id=:depId")
	public Double getSalaireMoyenByDepartementId(@Param("depId") int departementId);

	@Query("SELECT e FROM Employe e WHERE e.email=:email and e.password=:password")
	public Employe getEmployeByEmailAndPassword(@Param("email") String login, @Param("password") String password);

}
