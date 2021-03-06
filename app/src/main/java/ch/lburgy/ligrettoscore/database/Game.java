package ch.lburgy.ligrettoscore.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import ch.lburgy.ligrettoscore.type_converter.DateConverter;

@Entity
@TypeConverters(DateConverter.class)
public class Game implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private Date lastEdit;
    private int nbPlayers;

    public Game(String name, Date lastEdit, int nbPlayers) {
        this.name = name;
        this.lastEdit = lastEdit;
        this.nbPlayers = nbPlayers;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getLastEdit() {
        return lastEdit;
    }

    public int getNbPlayers() {
        return nbPlayers;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastEdit(Date lastEdit) {
        this.lastEdit = lastEdit;
    }

    public void setNbPlayers(int nbPlayers) {
        this.nbPlayers = nbPlayers;
    }

    public static final Comparator<Game> GAME_COMPARATOR = new Comparator<Game>() {
        @Override
        public int compare(Game o1, Game o2) {
            return o2.getLastEdit().compareTo(o1.lastEdit);
        }
    };
}
