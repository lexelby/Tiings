package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_19
	extends TilingType
{
	public TilingTypeP4_19(){
		super( "P4-19: Zig-zag", 4, SymmetryType.pgg );
 
		paramMin = new int[]{  0,  0};
		paramMax = new int[]{180,100};
		paramDef = new int[]{ 70, 70};
		paramName = new String[]{ "Angle", "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,1,2, 1},
            };
      info = "a=c\nb=d\nA+B=180\nA=C\n(B=D)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 2*(1+paramValues[1])/102.;
      double ln2 = 2-ln1;
      double s2 = Math.sin( paramValues[0] * DEG2RAD);
      double c2 = Math.cos( paramValues[0] * DEG2RAD);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, ln1, 0);
      baseTile.setPoint(2, ln1 + ln2 * c2, ln2 * s2);
      baseTile.setPoint(3, ln2 * c2, ln2 * s2 );

   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[1].getX(3);
      offsets[3] = tiles[0].getY(2)-tiles[1].getY(3);
   }
}
