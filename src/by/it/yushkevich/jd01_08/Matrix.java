package by.it.yushkevich.jd01_08;

class Matrix extends Var {

    private double[][] value;


    public Matrix(double[][] value) {
        this.value = value.clone();
    }


    public Matrix(Matrix otherMatrix) {

        this.value = otherMatrix.value.clone();
    }


    public Matrix(String textMatrix) {


        String textForRows = textMatrix.replaceAll("[{]+|[}]{2,}", "");
        textForRows = textForRows.trim();
        String[] rows = textForRows.split("},");
        int rowsCount = rows.length; //6
        String[] col = rows[0].trim().split(",");
        int colCount = col.length;
        for (int i = 0; i < col.length; i++) {
            col[i].trim();
        }

        String[][] buffArray = new String[rowsCount][colCount];
        for (int i = 0; i < buffArray.length; i++) {
            buffArray[i] = rows[i].trim().split("[,]");
        }

        double[][] value = new double[rowsCount][colCount];
        for (int i = 0; i < buffArray.length; i++) {
            for (int j = 0; j < buffArray[i].length; j++) {
                value[i][j] = Double.parseDouble(buffArray[i][j]);
            }
        }
        this.value = value;

    }


    @Override
    public String toString() {

        StringBuilder out = new StringBuilder();
        out.append("{");


        for (int i = 0; i < value.length; i++) {
            out.append("{");
            for (int j = 0; j < value[i].length; j++) {

                out.append(value[i][j]);

                if (j < value[i].length - 1) {
                    out.append(",");

                }
            }

            out.append("}");
            if (i < value.length - 1) {
                out.append(",");
            }
        }
        out.append("}");

        return out.toString();
    }
}
