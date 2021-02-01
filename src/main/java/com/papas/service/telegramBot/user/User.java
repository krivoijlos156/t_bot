package com.papas.service.telegramBot.user;

import com.papas.service.telegramBot.user.common.IdAuditedEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`user`", indexes = @Index(columnList = "telegramId"))
public class User extends IdAuditedEntity {
    @Column(nullable = false, unique = true)
    private int telegramId;
    private StateChat stateChat;
    @ElementCollection
    private List<Integer> hashTagIds= new ArrayList<>();
//    @ManyToMany
//    @JoinTable(
//            name = "stream_hashtag", indexes = @Index(columnList = "stream_id"),
//            joinColumns = {@JoinColumn(name = "stream_id")},
//            inverseJoinColumns = {@JoinColumn(name = "hashtag_id")}
//    )
//    private Set<HashTag> hashTags = new HashSet<>();

    public User() {
    }

    public User(int telegramId) {
        this.telegramId = telegramId;
    }

    //    public Set<HashTag> addHashTag(HashTag hashTag){
//        hashTags.add(hashTag);
//        return hashTags;
//    }


    public int getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(int telegramId) {
        this.telegramId = telegramId;
    }

    public StateChat getStateChat() {
        return stateChat;
    }

    public void setStateChat(StateChat stateChat) {
        this.stateChat = stateChat;
    }

    public List<Integer> getHashTagIds() {
        return hashTagIds;
    }

    public void setHashTagIds(List<Integer> hashTagIds) {
        this.hashTagIds = hashTagIds;
    }

    //    public Set<HashTag> getHashTags() {
//        return hashTags;
//    }
//
//    public void setHashTags(Set<HashTag> hashTags) {
//        this.hashTags = hashTags;
//    }
}
