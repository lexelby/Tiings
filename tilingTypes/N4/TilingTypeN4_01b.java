package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_01b
	extends TilingType
{
	public TilingTypeN4_01b(){
		super( "N4-1b", 4, SymmetryType.pgg);

		paramMin = new int[]{};
		paramMax = new int[]{};
		paramDef = new int[]{};
		paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,3, 0,3,2, 0},
            {1, 2,3, 0,2,1, 0},
            {1, 2,3, 1,2,1, 0},
            
            {0, 0,3, 3,1,0, 1},
            {0, 2,3, 4,3,2, 1},
            {1, 2,3, 4,2,1, 1},
            {1, 2,3, 5,2,1, 1},
      };
      info = "a=b+c\nc=d\nA=30\nB=120\nD=60\n(C=150)";
   }

   public void recalcBase(double[] paramValues) {
      
      double a = 30;
      double b = 120;

      double ln2 = (Math.sqrt(3)+1)/2;  // other long side
      double ln4 = ln2-1;  // short sides

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
      offsets[0] = tiles[2].getX(1)-tiles[6].getX(0);
      offsets[1] = tiles[2].getY(1)-tiles[6].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(0);
   }
}
