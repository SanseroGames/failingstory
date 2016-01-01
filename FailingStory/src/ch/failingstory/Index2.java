package ch.failingstory;

import org.newdawn.slick.geom.Vector2f;

/**
 * Struktur zur Definierung einer zweidimensionalen Index-Position.
 * @author Tom Wendel {@link https://github.com/tomwendel}
 */
public class Index2 {
	/**
     * X Anteil
     */
    public int X;

    /**
     * Y Anteil
     */
    public int Y;

    /**
     * Initialisierung
     * 
     * @param x X Anteil
     * @param y Y Anteil
     */
    public Index2(int x, int y)
    {
        this.X = x;
        this.Y = y;
    }

    /**
     * Initialisierung
     * 
     * @param value Initialwerte
     */
    public Index2(Index2 value) {
    	this(value.X, value.Y);
    }

    /**
     * Normalisiert die X-Achse auf die angegebene Größe.
     * 
     * @param size Maximalwert für X
     */
    public void normalizeX(int size)
    {
        X = Index2.normalizeAxis(X, size);
    }

    /**
     * Normalisiert die X-Achse auf die angegebene Größe.
     * 
     * @param size 2D-Größe (X-Anzeil wird genommen)
     */
    public void normalizeX(Index2 size)
    {
        normalizeX(size.X);
    }

    /**
     * Normalisiert die Y-Achse auf die angegebene Größe.
     * @param size Maximalwert für Y
     */
    public void normalizeY(int size)
    {
        Y = Index2.normalizeAxis(Y, size);
    }

    /**
     * Normalisiert die Y-Achse auf die angegebene Größe.
     * @param size 2D-Größe (Y-Anzeil wird genommen)
     */
    public void normalizeY(Index2 size)
    {
        normalizeY(size.Y);
    }

    /**
     * Normalisiert den Wert von X und Y auf den angegebenen Grenzbereich.
     * @param x Größe in X-Richtung
     * @param y Größe in Y-Richtung
     */
    public void normalizeXY(int x, int y)
    {
        normalizeX(x);
        normalizeY(y);
    }

    /**
     * Normalisiert den Wert von X und Y auf den angegebenen Grenzbereich.
     * @param size 2D Size
     */
    public void normalizeXY(Index2 size)
    {
        normalizeXY(size.X, size.Y);
    }

    /**
     * Ermittelt die kürzeste Entfernung zum Ziel auf einer normalisierten X-Achse.
     * @param x Ziel
     * @param size Normalisierungsgröße
     * @return Entfernung
     */
    public int getShortestDistanceX(int x, int size)
    {
        return Index2.getShortestDistanceOnAxis(X, x, size);
    }

    /**
     * Ermittelt die kürzeste Entfernung zum Ziel auf einer normalisierten Y-Achse.
     * @param y Ziel
     * @param size Normalisierungsgröße
     * @return Entfernung
     */
    public int getShortestDistanceY(int y, int size)
    {
        return Index2.getShortestDistanceOnAxis(Y, y, size);
    }

    /**
     * Ermittelt die kürzeste Entfernung zum Ziel auf den normalisierten Achsen.
     * @param destination Ziel
     * @param size Normalisierungsgröße
     * @return Entfernung
     */
    public Index2 getShortestDistanceXY(Index2 destination, Index2 size)
    {
        return new Index2(
            getShortestDistanceX(destination.X, size.X), 
            getShortestDistanceY(destination.Y, size.Y));
    }

    /**
     * Ermittelt die Entferung zum Nullpunkt.
     * @return
     */
    public double getLength()
    {
        return Math.sqrt(getLengthSquared());

    }

    /**
     * Ermittelt die Entfernung zum Nullpunkt im Quadrat.
     * @return
     */
    public int getLengthSquared()
    {
        return (X * X) + (Y * Y);
    }
    
    public void add(Index2 index){
    	X += index.X;
    	Y += index.Y;
    }
    
    public void subtract(Index2 index){
    	X -= index.X;
    	Y -= index.Y;
    }
    
    public void multiply(int scale){
    	X *= scale;
    	Y *= scale;
    }
    
    public void divide(int scale){
    	X /= scale;
    	Y /= scale;
    }

    public static Vector2f toVector2(Index2 index)
    {
        return new Vector2f(index.X, index.Y);
    }

    /**
     * Normalisiert einen Integer auf die angegebene Maximalgröße.
     * @param value Wert
     * @param size Normalisierungsgröße
     * @return Normalisierten Wert
     */
    public static int normalizeAxis(int value, int size)
    {
        // Sicherheitsabfrage für die Normalisierungsgröße
        if (size < 1)
            throw new IllegalArgumentException("Size darf nicht kleiner als 1 sein");

        value %= size;
        if (value < 0) value += size;
        return value;
    }

    /**
     * Ermittelt die kürzeste Entfernung von Ursprung zum Ziel auf einer normalisierten Achse.
     * 
     * @param origin Ursprungswert 
     * @param destination Zielwert
     * @param size Normalisierungsgröße
     */
    public static int getShortestDistanceOnAxis(int origin, int destination, int size)
    {
        origin = normalizeAxis(origin, size);
        destination = normalizeAxis(destination, size);
        int half = size / 2;

        int distance = destination - origin;
        if (distance > half)
            distance -= size;
        else if (distance < -half)
            distance += size;
        return distance;
    }

    public String toString()
    {
        return "(" + X + "/" + Y + ")";
    }

    public int hashCode()
    {
        return 
            (X << 16) + 
            Y;
    }

    /**
     * Null-Index
     */
    public static Index2 Zero = new Index2(0, 0); 

    /**
     * Index(1,1)
     */
    public static Index2 One = new Index2(1, 1); 

    /**
     *  Einheitsindex für X
     */
    public static Index2 UnitX = new Index2(1, 0);

    /**
     * Einheitsindex für Y
     */
    public static Index2 UnitY = new Index2(0, 1);

    /**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object other) {
		if (other instanceof Index2) {
			Index2 o = (Index2) other;
			
			return (o.X == X) && (o.Y == Y);
		}
		
		return false;
	}
}
