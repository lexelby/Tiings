package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_31
   extends TilingType
{
   public TilingTypeNC5_31(){
      super( "NC5-31", 5, SymmetryType.p2 );

      paramMin = new int[]{-100};
      paramMax = new int[]{ 100};
      paramDef = new int[]{  50};
      paramName = new String[]{ "Indent" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,0, 0,0,2, 0},
            {1, 2,3, 0,2,1, 0},
            {1, 2,3, 1,2,1, 0},
      };
      info = "a=c=d\nD+E=360\nA=D\nB=C\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .75;
      double ln3 = ln1*paramValues[0] / 100.;
      double ln4 = 2*ln1-ln3;
      double e = Math.acos(.25)/DEG2RAD;
      double b = 180-e-e;

      double x4 = ln1*Math.cos( b * DEG2RAD);
      double y4 = ln1*Math.sin( b * DEG2RAD);
      double x3 = x4 - ln3;
      double y3 = y4;
      double x2 = x3 + x4;
      double y2 = y3 + y4;
      double x1 = ln4;
      double y1 = 0;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(1)-tiles[0].getX(1);
      offsets[1] = tiles[2].getY(1)-tiles[0].getY(1);
      offsets[2] = tiles[3].getX(0)-tiles[2].getX(4);
      offsets[3] = tiles[3].getY(0)-tiles[2].getY(4);
   }
}
