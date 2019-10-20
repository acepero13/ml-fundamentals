package knn.io.mnist;

import knn.datastructures.Matrix;

import java.io.*;

public class MNistReader {
    private final String filePath;
    private final String labelFilePath;

    public MNistReader(String filePath, String labelFilePath) {
        this.filePath = filePath;
        this.labelFilePath = labelFilePath;
    }


    public Matrix load() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));
        int magicNumber = dataInputStream.readInt();
        int numberOfItems = dataInputStream.readInt();
        int nRows = dataInputStream.readInt();
        int nCols = dataInputStream.readInt();

        DataInputStream labelInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(labelFilePath)));
        int labelMagicNumber = labelInputStream.readInt();
        int numberOfLabels = labelInputStream.readInt();

        assert numberOfItems == numberOfLabels;

        for(int i = 0; i < numberOfItems; i++) {
            int [][] mnistMatrix = new int[nRows][nCols];
            int label = labelInputStream.readUnsignedByte();
            for (int r = 0; r < nRows; r++) {
                for (int c = 0; c < nCols; c++) {
                    mnistMatrix[r][c]= dataInputStream.readUnsignedByte();
                }
            }
        }
        dataInputStream.close();
        labelInputStream.close();
        return null;

    }
}
