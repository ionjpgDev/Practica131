package Pilas.ejercicio2;

public class Examen {
    private int nroExamen,notaObt;
    private String nombreOso,idiomaEva;

    public Examen(int nroExamen, int notaObt, String nombreOso, String idiomaEva) {
        this.nroExamen = nroExamen;
        this.notaObt = notaObt;
        this.nombreOso = nombreOso;
        this.idiomaEva = idiomaEva;
    }

    public int getNroExamen() {
        return nroExamen;
    }

    public int getNotaObt() {
        return notaObt;
    }

    public String getNombreOso() {
        return nombreOso;
    }

    public String getIdiomaEva() {
        return idiomaEva;
    }

    public void setNroExamen(int nroExamen) {
        this.nroExamen = nroExamen;
    }

    public void setNotaObt(int notaObt) {
        this.notaObt = notaObt;
    }

    public void setNombreOso(String nombreOso) {
        this.nombreOso = nombreOso;
    }

    public void setIdiomaEva(String idiomaEva) {
        this.idiomaEva = idiomaEva;
    }

    @Override
    public String toString() {
        return "\t\"Examen{" +
                "nroExamen=" + nroExamen +
                ", notaObt=" + notaObt +
                ", nombreOso='" + nombreOso + '\'' +
                ", idiomaEva='" + idiomaEva + '\'' +
                '}';
    }
}
