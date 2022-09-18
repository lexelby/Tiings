package tilingTypes;

public interface ITilingType {

	public int getNumParam();
	public int getParamMin(int p);
	public int getParamMax(int p);
	public int getParamDefault(int p);
	public String getParamName(int p);

   public SymmetryType symmetryType();
   public void recalc( final double[] paramValues, double rotation, double zoom );
   public ITile[] getTiles();
   public ITile getTile();
   public double[] getOffsets();
   public String getInfo();
   public int[] getTileLabels();
   public void initialise();
}
