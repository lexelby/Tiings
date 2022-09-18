package tilingTypes.N5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_10
   extends TilingType
{
   public TilingTypeN5_10(){
      super( "N5-10: Richard E. James III, 1975", 5, SymmetryType.p2 );

      paramMin = new int[]{ 53};
      paramMax = new int[]{127};
      paramDef = new int[]{ 90};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,4, 0},
            {0, 0,1, 1,0,4, 0},
            {1, 0,1, 2,0,4, 0},
            {2, 2,3, 1,2,3, 1},
            {2, 2,3, 3,2,3, 1},
      };
      info = "a=b=c+e\nA=90\nB+E=180\nB+2C=360\n(C+D=270)";
   }

   public void recalcBase(double[] paramValues) {
      // get angles
      double a = paramValues[0];
      //double b = 180-a/2;
      //double c = 90+a/2;
      //double d = 180-a;

      // get side lengths
      double v = Math.sqrt(2)* Math.cos((a-45) * DEG2RAD);
      double w = Math.sqrt(2)* Math.sin((a-45) * DEG2RAD);
      double dvwdx = 1 + Math.tan(a/2 * DEG2RAD);
      // vw - x*dvwdx = ln1
      double x = (v+w - 1) / dvwdx;
      double ln = .75;
      double ln3 = ln*(v-x);
      double ln2 = ln-ln3;


      double x2 = ln + ln2 * Math.cos( (a) * DEG2RAD);
      double y2 =      ln2 * Math.sin( (a) * DEG2RAD);
      double x3 =      ln3 * Math.cos( (a-90) * DEG2RAD);
      double y3 = ln + ln3 * Math.sin( (a-90) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4,  0, ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[2].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[2].getY(3);
      offsets[2] = tiles[4].getX(1)-tiles[5].getX(2);
      offsets[3] = tiles[4].getY(1)-tiles[5].getY(2);
   }
}
