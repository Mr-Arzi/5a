public class GammaFunction {

    private double gammaValue;

    // Gamma para enteros: Γ(n) = (n-1)!
    public double computeIntGamma(int intValue) {
        if (intValue < 1) {
            throw new IllegalArgumentException("El valor debe ser >= 1");
        }
        double result = 1;
        for (int i = 2; i < intValue; i++) {
            result = result * i;
        }
        gammaValue = result;
        return gammaValue;
    }

    // Gamma para enteros o múltiplos de 0.5, usando Γ(x) = (x-1) * Γ(x-1)
    public double computeDblGamma(double doubleValue) {
        if (doubleValue < 0.5) {
            throw new IllegalArgumentException("El valor debe ser >= 0.5");
        }
        gammaValue = gammaRecursive(doubleValue);
        return gammaValue;
    }

    private double gammaRecursive(double x) {
        if (Math.abs(x - 1.0) < 1e-9) {
            return 1.0;                  // Γ(1) = 1
        }
        if (Math.abs(x - 0.5) < 1e-9) {
            return Math.sqrt(Math.PI);   // Γ(1/2) = √π
        }
        return (x - 1.0) * gammaRecursive(x - 1.0);
    }
}

