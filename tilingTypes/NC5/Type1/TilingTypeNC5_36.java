package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_36
   extends TilingType
{
   public TilingTypeNC5_36(){
      super( "NC5-36", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{ 90,100};
      paramDef = new int[]{ 40, 50};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 2,0, 0,0,2, 0},
            {0, 1,2, 0,1,2, 1},
            {0, 1,2, 1,1,2, 1},

            {1, 0,1, 2,4,3, 1},
            {1, 2,0, 4,0,2, 1},
            {0, 1,2, 4,1,2, 0},
            {0, 1,2, 5,1,2, 0},
      };
      info = "a=d\nD+E=360\nB=90\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double b = paramValues[0];
      double ln1 = getParam( paramValues,1)/100.;
      double ln2 = 1-ln1;
      double ln3 = ln1*2*Math.cos(b*DEG2RAD)+ln2*Math.cos((b+b)*DEG2RAD);

      double x4 =      ln1 * Math.cos( b * DEG2RAD);
      double y4 =      ln1 * Math.sin( b * DEG2RAD);
      double x3 = x4 + ln2 * Math.cos( (b+b) * DEG2RAD);
      double y3 = y4 + ln2 * Math.sin( (b+b) * DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;
      double x1 = ln3;
      double y1 = 0;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(4)-tiles[0].getX(2);
      offsets[1] = tiles[7].getY(4)-tiles[0].getY(2);
      offsets[2] = tiles[6].getX(4)-tiles[0].getX(0);
      offsets[3] = tiles[6].getY(4)-tiles[0].getY(0);
   }
}
