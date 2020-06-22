package com.pfe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfe.entity.Facture;
@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
	@Query(value="SELECT * FROM facture;",nativeQuery = true)
	List<Facture> findFactureByUserId(Long id);
//SELECT F.facture_counter , F.date_facturation , F.tva, C.id_client , C.ice , DF.prixttc , P.code_produit , P.designation , P.quantite FROM facture F JOIN client C  JOIN detailsfacture DF JOIN produit P WHERE F.id_client_id_client = C.id_client AND DF.id_facture_id_facture = F.id_facture AND DF.id_produit_id_produit = P.id_produit;
}
