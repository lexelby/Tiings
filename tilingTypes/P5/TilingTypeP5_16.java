package tilingTypes.P5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP5_16
	extends TilingType
{
	public TilingTypeP5_16(){
		super( "P5-16: Type 5, Flower", 5, SymmetryType.p6 );

		paramMin = new int[]{  0,  0};
		paramMax = new int[]{270,100};
		paramDef = new int[]{120, 50};
		paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,4, 0},
            {0, 0,1, 1,0,4, 0},
            {0, 0,1, 2,0,4, 0},
            {0, 0,1, 3,0,4, 0},
            {0, 0,1, 4,0,4, 0},
           };
      info = "a=b\nd=e\nA=60\nD=120\n(B+C+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double h = Math.sqrt(3)/6;
      double ln2 = paramValues[1]/100.;
      double c = ln2 * Math.cos( paramValues[0] * DEG2RAD);
      double s = ln2 * Math.sin( paramValues[0] * DEG2RAD);
      double x3 = 1     -c/2 -s*h;
      double y3 = h*2   +s/2 -c*h;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  1,  0);
      baseTile.setPoint(2,1-c,  s);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, .5,3*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(3)-tiles[3].getX(3);
      offsets[1] = tiles[5].getY(3)-tiles[3].getY(3);
      offsets[2] = tiles[1].getX(3)-tiles[3].getX(3);
      offsets[3] = tiles[1].getY(3)-tiles[3].getY(3);
   }
}
