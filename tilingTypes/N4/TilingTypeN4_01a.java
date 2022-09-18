package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_01a
	extends TilingType
{
	public TilingTypeN4_01a(){
		super( "N4-1a", 4, SymmetryType.p2 );

		paramMin = new int[]{  0};
		paramMax = new int[]{ 72};
		paramDef = new int[]{ 50};
		paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,3, 0,3,2, 0},
            {1, 2,3, 0,2,1, 0},
            {1, 2,3, 1,2,1, 0},
            };
      info = "c=d\nB+D=180\n2C+D=360\n(2A+B=180)";
   }

   public void recalcBase(double[] paramValues) {
      
      double a = paramValues[0];
      double b = 180-2*a;
      double e = 180-5*a/2;
      double f = 3*a/2;

      double ln2 = Math.sin( e * DEG2RAD) / Math.sin( f * DEG2RAD);  // other long side
      double ln3 = Math.sin( a * DEG2RAD) / Math.sin( f * DEG2RAD);  //diagonal
      double ln4 = ln3/2 / Math.cos( a/2 * DEG2RAD );  // short sides

      double x2 = 1 - ln4 * Math.cos( b * DEG2RAD);
      double y2 = ln4 * Math.sin( b * DEG2RAD);
      double x3 = ln2 * Math.cos( a * DEG2RAD);
      double y3 = ln2 * Math.sin( a * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  1,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[2].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(0);
   }
}
