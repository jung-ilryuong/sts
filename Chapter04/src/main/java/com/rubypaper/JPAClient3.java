package com.rubypaper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JPAClient3 {
	
	
	public static void main(String[] args) {
		// EntityManager 생성
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");

				EntityManager em = emf.createEntityManager();

				
				//Transaction 생성
				EntityTransaction tx=em.getTransaction();
				

					
					//삭제 조회
//					Board board=em.find(Board.class, 6L);
//					board.setSeq(6L);
//					
//					board.setSeq(6L);
//					em.remove(board);
					
					
			
	}

}