package com.example.projet;

import com.example.projet.dao.MemberRepository;
import com.example.projet.entities.EnseignantChercheur;
import com.example.projet.entities.Etudiant;
import com.example.projet.entities.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ProjetApplication implements CommandLineRunner {

    @Autowired
    MemberRepository memberRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Membre> membreList = memberRepository.findAll();
        Etudiant etudiant =(Etudiant) memberRepository.findById(1L).get();
        etudiant.setSujet("devops");
        memberRepository.save(etudiant);
        Membre membre =(Membre) memberRepository.findById(3L).get();
        memberRepository.delete(membre);

        /*Etudiant etd1 = Etudiant.builder()
                .cin("123456")
                .dateInscription(new Date())
                .dateNaissance(new Date())
                .diplome("mastère")
                .email("etd1@gmail.com")
                .password("pass1")
                .cv("cv1")
                .nom("abid")
                .prenom("marwen")
                .sujet("blockchain")
                .build();
        memberRepository.save(etd1);
        EnseignantChercheur chercheur1 = EnseignantChercheur.builder()
                .cin("123456")
                .dateNaissance(new Date())
                .email("etd1@gmail.com")
                .password("pass1")
                .cv("cv1")
                .nom("abid")
                .prenom("marwa")
                .grade("1")
                .etablissement("Enis")
                .build();
        EnseignantChercheur chercheur2 = EnseignantChercheur.builder()
                .cin("123456")
                .dateNaissance(new Date())
                .email("etd1@gmail.com")
                .password("pass1")
                .cv("cv1")
                .nom("fathi")
                .prenom("Samira")
                .grade("2")
                .etablissement("Enis")
                .build();
        memberRepository.save(chercheur1);
        memberRepository.save(chercheur2);*/
    }
}