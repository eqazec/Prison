/**
 * (C) 2014 SirFaizdat
 */
package me.sirfaizdat.prison.scoreboard;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import me.sirfaizdat.prison.core.Core;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

/**
 * @author SirFaizdat
 */
public class PScoreboard {

	Scoreboard sb;
	Objective obj;
	Player player;
	Map<String, ScoreboardEntry> scores;

	public PScoreboard(Scoreboard sb, Player player) {
		this.sb = sb;
		this.obj = sb.registerNewObjective("prison", "dummy");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName(Core.colorize("&6&lPrison"));
		this.player = player;
		scores = new HashMap<String, ScoreboardEntry>();
	}

	public void generateScoreboard(HashMap<String, ScoreboardEntry> newScores) {
		player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
		int id = scores.size() + 2;
		for (Entry<String, ScoreboardEntry> oldSet : scores.entrySet()) {
			sb.resetScores(oldSet.getValue().getDisplay());
			sb.resetScores(oldSet.getValue().getValue());
		}
		for (Entry<String, ScoreboardEntry> entrySet : newScores.entrySet()) {
			ScoreboardEntry entry = entrySet.getValue();

			Score score = obj.getScore(entry.getDisplay());
			score.setScore(id);

			Score score2 = obj.getScore(entry.getValue());
			id = id - 1;
			score2.setScore(id);
			id--;
		}
		player.setScoreboard(sb);
		this.scores = newScores;
	}

	public void updateScoreboard(HashMap<String, ScoreboardEntry> newScores) {
		player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
		int id = scores.size() + 2;
		for (Entry<String, ScoreboardEntry> oldSet : scores.entrySet()) {
			sb.resetScores(oldSet.getValue().getDisplay());
			sb.resetScores(oldSet.getValue().getValue());
		}
		for (Entry<String, ScoreboardEntry> entrySet : newScores.entrySet()) {
			ScoreboardEntry entry = entrySet.getValue();

			Score score = obj.getScore(entry.getDisplay());
			score.setScore(id);

			Score score2 = obj.getScore(entry.getValue());
			id = id - 1;
			score2.setScore(id);
			id--;
		}
		player.setScoreboard(sb);
		this.scores = newScores;
	}

	public Scoreboard getScoreboard() {
		return sb;
	}

	public Objective getObjective() {
		return obj;
	}

	public Player getPlayer() {
		return player;
	}

}
