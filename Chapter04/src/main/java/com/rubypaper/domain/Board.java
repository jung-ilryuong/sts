package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Table;

@Entity//프레임워크에서 jpa를 사용한다면 @Entity툴을 자동으로 스캔하여 처리하기 때문에 엔티티클래스를 명시적으로 등록하지 않아도 된다 하지만 jpa를 단독으로 사용하는 경우 엔티티를 클래스들을 영옥성 유닛에 등록해야 한다.

//@Table(name="BOARD") 스프링 프레임워크에서 jpa를 사용한다면 @entity듵은 엔티티들을 자동을로 시캔하여 처리하기 때문에 앤티티클래스를 명시적으로 릉록하지 않아도 된다.


@TableGenerator(name="BOARD_SEQ_GENERATOR", table = "ALL_SEQUENCES", pkColumnValue = "BOARD_SEQ",initialValue = 0,allocationSize = 1) //pkColumnValue : "BOARD_SEQ" 이름으로 증가되는 값을 저장하라

	
	// 엔티티로부터 생성된 객체는 반드시 다른 객체와 식별할 수 있어야 하는데 이를 위해서 반드시 사용해야 하는 어노테이션이 @ID
	// 테이블에 저장된 각 로우는 PK(Primary Key) 칼럼을 통해 유일한 데이터로 식별할 수 있다. 그리고 이런 테이블과 매핑되는 엔티티 역시 PK 칼럼과 매핑될 식별자를 가지고 있어야 하는데 이를 식별자 필드라고 한다. JPA는 @Id를 이용해서 식별자 필드를 매핑한다.
	
	  //@Id가 선언된 필드에 기본 키 값을 자동으로 할당 strategy : 자동생성 전략을 선택
	                 //TABLE, SEQUENCE,IDENTITY(auto_increment나 IDENTITY를 이용하여 PK값을 생성,일반적으로 MySQL 이용시 사용),AUTO(기본값)

public class Board {
	
	//엔티티로부터 생성한 객체는 반드시 다른 객체와 식별할 수 있어야 하는데 이를 위해서 반드시 사용해야하는 어노에티션이 @ID
	//테이블에 저장된 각 로우는 pk 칼럼을 통해 유일한 데이터로 식별할 수 있다. 그리고 이런 테이블과매피되는 엔티티 역시 pk갈럼과 맹핑될 식별자를
	
	@Id//테이블의 ㄱ본키, @ID가 없는 엔티티는 사용못함
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_GENERATOR")//기본기 값 자동할당
					//table, sequence,identity,auto(기본값)
	private Long seq;

	//@column: 엔티티 변수와 테이블을 칼럼을 매핑할 때 사용. 일반적으로 엔티티의 변수 이름과 칼럼 이름이 다를 때 사용, 생략하면 기본적으로 변수 이름과 동일한 이름이어야 함
//name: 생략시 프로퍼티명과 동일하게 매핑, unique : unique 제약조건 추가(기본값: false), nullalbe : null 상태 허용여부(false)
	//insertable: insert를 생성할때 이 칼럼을 포함할것인지 결정(True), updatable : update를 생설할때 이 칼럼을 포함할것인지 결정
	//columnDefinition: 이 칼럼에 대한 ddl 문을 직접 기술, length: 문자열 타입의 칼럼 길이 지정(255)
	//precesion: 수자 타입의 전체 자릿수 지정(0), scale: 숫자 타입의 소수점 자릿수 지정(0)	
	
	
	private String title;
	private String writer;
	private String content;
	
	//@Transient 엔티티 클래스ㅜ아 변수들은 대부분 테이블의 칼럼과 매핑된다. 그러나 몇몇 변수는 매핑되는 칼럼이 없거나 검색 관련 변수 값이 임시로 사용되는 편수 
	
	@Temporal(TemporalType.DATE)
	private Date createDate;
	private Long cnt;
	
	

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}
}
