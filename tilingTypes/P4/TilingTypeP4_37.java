package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_37
	extends TilingType
{
	public TilingTypeP4_37(){
		super( "P4-37: Split square", 4, SymmetryType.p4 );
 
		paramMin = new int[]{  0};
		paramMax = new int[]{100};
		paramDef = new int[]{ 40};
		paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,3, 0,3,2, 0},
            {0, 0,3, 0,0,1, 0},
            {0, 2,3, 2,3,2, 0},
            };
      info = "a+c=b\nA=90\nB=90\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 1;
      double ln2 = ln1*getParam( paramValues,0)/100.;
      double ln3 = ln1 -ln2;

      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, ln1, 0);
      baseTile.setPoint(2, ln1, ln2 );
      baseTile.setPoint(3,   0, ln3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(1);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(1);
      offsets[2] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[0].getY(0);
   }
}
