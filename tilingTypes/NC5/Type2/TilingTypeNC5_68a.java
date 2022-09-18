package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_68a
   extends TilingType
{
   public TilingTypeNC5_68a(){
      super( "NC5-68a", 5, SymmetryType.pg );

      paramMin = new int[]{  0};
      paramMax = new int[]{180};
      paramDef = new int[]{ 60};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,1,2, 0},
            {0, 4,0, 0,2,3, 1},
            {1, 4,3, 2,1,2, 1},
      };
      info = "a=c=d=e\nA+B=180\nB+E=360\n(A+C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double an = paramValues[0];
      double s1 = ln*Math.sin((180-an)/4 * DEG2RAD);
      double c1 = ln*Math.cos((180-an)/4 * DEG2RAD);
      double s2 = ln*Math.sin((180-an)/2 * DEG2RAD);
      double c2 = ln*Math.cos((180-an)/2 * DEG2RAD);

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,c2+c2,  0);
      baseTile.setPoint(2,c2+c2+c1, s1);
      baseTile.setPoint(3, c1+c2, s1+s2);
      baseTile.setPoint(4, c1, s1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[1].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[1].getY(1);
   }
}
