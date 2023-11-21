package Lab7.adapter;

import Lab7.adaptee.FileLoader;
import Lab7.target.FileImporter;

import java.util.List;

// FileLoader<E>(Adaptee)를 받아 FileImporter<E>(Target)로 바꿔주는 어댑터 클래스
public class FileLoaderImporterAdapter<E> implements FileImporter<E> {
    // Adaptee(기존 클래스): FileLoader<E>
    FileLoader<E> adaptee;

    public FileLoaderImporterAdapter(FileLoader<E> loader) {
        this.adaptee = loader;
    }

    // adaptee의 메서드로 연결
    @Override
    public List<E> importFile(String filepath) {
        return adaptee.load(filepath);
    }

    @Override
    public void exportFile(String filepath, List<E> list) {
        adaptee.save(filepath, list);
    }
}
