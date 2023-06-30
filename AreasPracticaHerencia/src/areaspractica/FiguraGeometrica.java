package areaspractica;
class FiguraGeometrica {
    protected double area;
    protected double perimetro;

    public FiguraGeometrica() {
        area = 0.0;
        perimetro = 0.0;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    public void calcularArea() {
        // Implementar cálculo del área segun la figura
    }

    public void calcularPerimetro() {
        // Implementa cálculo del perímetro segun la figura
    }

    public void mostrarResultados() {
        System.out.println("Area: " + area);
        System.out.println("Perimetro: " + perimetro);
    }
}