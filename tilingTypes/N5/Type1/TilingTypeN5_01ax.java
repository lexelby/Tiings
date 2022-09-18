package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01ax
   extends TilingType
{
   public TilingTypeN5_01ax(){
      super( "N5-1ax", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{ "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,0,1, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 0,1, 2,2,1, 0},

            {0, 4,0, 0,1,2, 1},
            {1, 2,1, 4,0,1, 1},
            {1, 1,0, 5,0,1, 1},
            {0, 0,1, 6,2,1, 1},
      };
      info = "a=c\nb=2a\nD=90\nA+B=180\nA+2C=360\n(C+E=270)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln1 = 1.3 * paramValues[0]/100.;
      double ln2 = 1.3 - ln1;
      double ln3 = Math.sqrt(ln1 * ln1 + ln2 * ln2);
      double ln4 = ln3 / 2;
      double an = Math.atan2(ln1, ln2)/ DEG2RAD;
      double b = 60 + 2 * an / 3;
      double c = 90+b/2;
      
      double x4 =      -ln4*Math.cos(b * DEG2RAD);
      double y4 =       ln4*Math.sin(b * DEG2RAD);
      double x2 = ln3 + x4;
      double y2 =       y4;
      double x3 = x2 +  ln2*Math.cos((-c-b) * DEG2RAD);
      double y3 = y2 +  ln2*Math.sin((-c-b) * DEG2RAD);
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln3,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(3)-tiles[2].getX(3);
      offsets[1] = tiles[1].getY(3)-tiles[2].getY(3);
      offsets[2] = tiles[3].getX(4)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(4)-tiles[7].getY(1);
   }
}
