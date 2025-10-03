package Multipilas.ejercicio3;

public class Auxiliar {
    private String ci;
    private int cargaHoraria,cantidadMaterias;
    private double salario;

    private String nombre;

    public Auxiliar(String ci, String nombre, int cargaHoraria, int cantidadMaterias, double salario) {
        this.ci = ci;
        this.nombre = nombre;
        this.cargaHoraria = cargaHoraria;
        this.cantidadMaterias = cantidadMaterias;
        this.salario = salario;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(int cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Auxiliar{" +
                "ci=" + ci +
                ", cargaHoraria=" + cargaHoraria +
                ", cantidadMaterias=" + cantidadMaterias +
                ", salario=" + salario +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
