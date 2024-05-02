package com.kh.Final3.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.Final3.dto.MessageDto;

@Repository
public class MessageDao {

	@Autowired
	private SqlSession sqlSession;
	
	public MessageDto insert(MessageDto messageDto) {
		int sequence = sqlSession.selectOne("message.sequence");
		messageDto.setMessageNo(sequence);
		sqlSession.insert("message.save", messageDto);
		return sqlSession.selectOne("message.find", sequence);
	}
	
	// 조회
	public List<MessageDto> selectList(int chatroomNo) {
	    List<MessageDto> messageList = sqlSession.selectList("message.list", chatroomNo);
	    
	    // 각 메시지의 작성자 이름 설정
	    for (MessageDto messageDto : messageList) {
	        String senderName = sqlSession.selectOne("message.listSetName", messageDto.getMessageNo());
	        String senderGrade = sqlSession.selectOne("message.listSetGrade", messageDto.getMessageNo());
	        messageDto.setMessageSenderName(senderName);
	        messageDto.setMessageSenderGrade(senderGrade);
	    }
	    
	    return messageList;
	}
	
	// 무한스크롤 조회
	public List<MessageDto> selectListByPaging(int chatroomNo, int startRow, int endRow) {
	    Map<String, Object> data = new HashMap<>();
	    data.put("chatroomNo", chatroomNo);
	    data.put("startRow", startRow);
	    data.put("endRow", endRow);
	    
	    List<MessageDto> messageList = sqlSession.selectList("message.listByPaging", data);
	    
	    // 각 메시지의 작성자 이름 설정
	    for (MessageDto messageDto : messageList) {
	        String senderName = sqlSession.selectOne("message.listSetName", messageDto.getMessageNo());
	        String senderGrade = sqlSession.selectOne("message.listSetGrade", messageDto.getMessageNo());
	        messageDto.setMessageSenderName(senderName);
	        messageDto.setMessageSenderGrade(senderGrade);
	    }
	    
	    return messageList;
	}

	// 메시지 총 개수 조회
	public int count(int chatroomNo) {
	    return sqlSession.selectOne("message.count", chatroomNo);
	}
	
	
}
