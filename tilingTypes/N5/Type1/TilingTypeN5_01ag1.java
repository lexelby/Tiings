package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01ag1
   extends TilingType
{
   public TilingTypeN5_01ag1(){
      super( "N5-1ag1", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,180};
      paramDef = new int[]{ 60, 80};
      paramName = new String[]{"Relative length", "Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,1,2, 1},
            {0, 3,2, 0,2,3, 0},
            {1, 2,3, 2,1,2, 1},
      };
      info = "c=d\nA+B=180\nB+C=180\nD=E\n(C+2D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = paramValues[0]/100.;
      double ln2 = 1 - ln1;

      double a = paramValues[1];
      double e = a/2;
      double s1 = Math.sin(a * DEG2RAD);
      double c1 = Math.cos(a * DEG2RAD);
      double s2 = Math.sin(e * DEG2RAD);
      double c2 = Math.cos(e * DEG2RAD);
      double ln3 = ln1 + ln2*s2 / s1;

      double f = 1.5 / (c1 * ln1 + c2 * ln2 + 2 * ln3 - c1 * ln3);
      ln1 *=f;
      ln2 *=f;
      ln3 *=f;
      
      double x4 =      c1 * ln1;
      double y4 =      s1 * ln1;
      double x3 = x4 + c2 * ln2;
      double y3 = y4 + s2 * ln2;
      double x2 = x3 + ln3;
      double y2 = y3;
      double x1 = x2 - c1 * ln3;
      double y1 = y2 - s1 * ln3;

      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1,  x1,  y1);
      baseTile.setPoint(2,  x2,  y2);
      baseTile.setPoint(3,  x3,  y3);
      baseTile.setPoint(4,  x4,  y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[0].getX(4);
      offsets[1] = tiles[1].getY(0)-tiles[0].getY(4);
      offsets[2] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[0].getY(0);
   }
}
