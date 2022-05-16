package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JPAClient {
	public static void main(String[] args) {
		// EntityManager 생성 영속성 유닛을 설정하면 애플리케이션에서는 영송석 유닛 설정을 로딩해서 EntityManagerFactory를 생성할 수 있다
		EntityManagerFactory emf = 
Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		
		
		try {
			
		tx.begin();
		
		Board board = new Board();
		
		board.setTitle("제목7");
		board.setWriter("관리자");
		board.setContent("글연습2");
		board.setCreateDate(new Date());
		board.setCnt(0L);
		
		em.persist(board);
		
		tx.commit();
		
		}catch(Exception e) {
			
		}finally {
			em.close();
			emf.close();
		}
		
		
		/*
		 * try { // Transaction 시작 tx.begin();
		 * 
		 * // 수정할 게시글 조회 Board board = em.find(Board.class, 1L);
		 * board.setTitle("검색한 게시글의 제목 수정");
		 * 
		 * // Transaction commit tx.commit();
		 * 
		 * } catch (Exception e) { e.printStackTrace(); // Transaction rollback
		 * tx.rollback(); } finally { em.close(); emf.close(); }
		 */
	}
}
