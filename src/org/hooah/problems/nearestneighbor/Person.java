package org.hooah.problems.nearestneighbor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person implements Comparable<Person>, Serializable {
	
	private final String name;
	private final int position;
	private static final int MAX_FRIENDS = 3;
	private final List<Person> friends = new ArrayList<>();
	
	public Person(final String name, final int position){
		this.name = name;
		this.position = position;
	}
	
	public void addFriend(final Person friend){
		if(friends.size()>=MAX_FRIENDS) {
			throw new UnsupportedOperationException("Too many friends.");
		}else if(friend.position==this.position){
			throw new UnsupportedOperationException("Cannot add oneself as a friend.");
		}else {
			this.friends.add(friend);
		}
	}
	
	public void addFriends(final Person... friends){
		if(friends.length>MAX_FRIENDS) {
			throw new UnsupportedOperationException("Too many friends.");
		}else {
			this.friends.addAll(Arrays.asList(friends));
		}
	}
	
	public List<Person> getFriends(){
		return friends;
	}
	
	public int getPosition() {
		return position;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(final Person that) {
		return Integer.compare(this.getPosition(), that.getPosition());
	}
}
