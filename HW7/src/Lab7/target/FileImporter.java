package Lab7.target;

import java.util.List;

public interface FileImporter<E> {
    // 파일 가져오기
    List<E> importFile(String filepath);

    // 파일 내보내기
    void exportFile(String filepath, List<E> list);
}
