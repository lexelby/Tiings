package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_67
   extends TilingType
{
   public TilingTypeNC5_67(){
      super( "NC5-67", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{ 90,100,100};
      paramDef = new int[]{ 50, 30, 50};
      paramName = new String[]{ "Angle", "Relative length", "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {1, 1,2, 0,0,4, 0},
            {0, 3,2, 2,2,3, 0},

            {0, 1,0, 1,4,3, 1},
            {1, 3,2, 4,2,3, 1},
            {1, 1,2, 4,0,4, 1},
            {0, 3,2, 6,2,3, 1},
      };
      info = "a=c\nA+B=180\nB+E=360\n(A+C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double an = paramValues[0];
      double ln1 = 2. * paramValues[1]/100;
      double ln2 = 2 - ln1;
      double ln3 = ln2 * getParam( paramValues,2)/100;
      ln2 -= ln3;

      double x4 = ln2 * Math.cos( an * DEG2RAD);
      double y4 = ln2 * Math.sin( an * DEG2RAD);
      double x3 = x4 + ln3 * Math.cos( 2*an * DEG2RAD);
      double y3 = y4 + ln3 * Math.sin( 2*an * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1,  0);
      baseTile.setPoint(2,ln1 + x4, y4);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[6].getX(4);
      offsets[1] = tiles[3].getY(1)-tiles[6].getY(4);
      offsets[2] = tiles[5].getX(0)-tiles[0].getX(2);
      offsets[3] = tiles[5].getY(0)-tiles[0].getY(2);
   }
}
