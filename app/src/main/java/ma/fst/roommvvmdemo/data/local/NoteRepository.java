package ma.fst.roommvvmdemo.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import ma.fst.roommvvmdemo.data.local.Note;
import ma.fst.roommvvmdemo.data.local.NoteDao;
import ma.fst.roommvvmdemo.data.local.NoteDatabase;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {

    private final NoteDao noteDao;
    private final LiveData<List<Note>> allNotes;
    private final ExecutorService executorService;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insert(Note note) {
        executorService.execute(() -> noteDao.insert(note));
    }

    public void delete(Note note) {
        executorService.execute(() -> noteDao.delete(note));
    }

    public void deleteAllNotes() {
        executorService.execute(noteDao::deleteAllNotes);
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}