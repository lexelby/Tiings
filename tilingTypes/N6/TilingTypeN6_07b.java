package tilingTypes.N6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN6_07b
   extends TilingType
{
   public TilingTypeN6_07b(){
      super( "N6-7b", 6, SymmetryType.pg );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,100,180,100};
      paramDef = new int[]{ 20, 30, 70, 50};
      paramName = new String[]{ "Relative Length 1", "Relative Length 2", "Angle", "Point" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 5,4, 0,4,5, 0},
            {2, 4,5, 1,0,1, 1},

            {0, 1,0, 2,0,1, 1},
            {1, 5,4, 3,4,5, 1},
            {2, 4,5, 4,0,1, 0},
      };
      info = "a=d\nb=f\nc=e\nB=E\nA+B+C=360\n(D+E+F=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 1.5 * getParam(paramValues,0)/100.;
      double s = 1.5 - ln1;
      double ln2 = s * getParam(paramValues,1)/100.;
      double ln3 = s - ln2;

      double an1 = paramValues[2];
      double minang = Math.max(-an1, an1-180);
      double an2 = (180-minang)*paramValues[3]/100. +minang;
      double lnmin = Math.min(ln2,ln3);
      double dx = lnmin * Math.cos(an2*DEG2RAD);
      double dy = lnmin * Math.sin(an2*DEG2RAD);
      double an3 = Math.asin(dy/ln3)/DEG2RAD;
      double w = dx + (ln3+ln2-lnmin)*Math.cos(an3 * DEG2RAD);

      double x4 = ln1 * Math.cos(an1*DEG2RAD);
      double y4 = ln1 * Math.sin(an1*DEG2RAD);
      double x1 =  ln2<ln3 ? dx : w-dx;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, -dy);
      baseTile.setPoint(2,  w,  0);
      baseTile.setPoint(3, x4+w, y4);
      baseTile.setPoint(4, x4+x1, y4+dy );
      baseTile.setPoint(5, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[5].getX(0);
      offsets[3] = tiles[0].getY(1)-tiles[5].getY(0);
   }
}