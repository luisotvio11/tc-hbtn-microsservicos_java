package com.song.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {

	private List<Song> list = new ArrayList<Song>();

	public List<Song> getAllSongs() {
		return list;
	}

	public Song getSongById(Integer id) {

		for (Song listaSong : list) {

			if (listaSong.getId().equals(id))
				;

			return listaSong;
		}
		return null;

	}

	public void addSong(Song s) {

		list.add(s);
	}

	public void updateSong(Song s) {
		
		int index = list.indexOf(s);
		
		for (Song sons : list) {


			if (sons.getId().equals(s)) {

				list.set(index, s);
			}
		}

	}

	public void removeSong(Song s) {

		list.remove(s);
	}
}
