package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_76b
   extends TilingType
{
   public TilingTypeNC6_76b(){
      super( "NC6-76b", 6, SymmetryType.p4m );

      paramMin = new int[]{  0,  0,-135};
      paramMax = new int[]{100, 90, 135};
      paramDef = new int[]{ 40, 20,  30};
      paramName = new String[]{"Relative Length", "Angle 1", "Angle 2"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,2, 0,0,4, 0},
            {0, 0,2, 1,0,4, 0},
            {0, 0,2, 2,0,4, 0},

            {0, 2,3, 0,2,3, 1},
            {0, 0,2, 4,0,4, 1},
            {0, 0,2, 5,0,4, 1},
            {0, 0,2, 6,0,4, 1},
      };
      info = "a=b\nc=f\nA=90\nD=90\nB+F=360\n(C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 0.7;
      
      double ang1 = getParam(paramValues,1);
      double x5 = ln * getParam(paramValues,0)/100;
      double y5 = x5 * Math.tan((ang1-45) * DEG2RAD);
      
      double ang2 = getParam(paramValues,2);
      double c = Math.cos((ang1-45+ang2)*DEG2RAD);
      double s = Math.sin((ang1-45+ang2)*DEG2RAD);
      double x4, y4, x3, y3;
      if( c<0 && s>0 && -(ln-y5)*c > s*(ln+x5)) {
         x4 = -ln;
         y4 = y5 - (ln+x5)*s/c;
         x3 = -ln;
         y3 = ln;
      } else if( s>0 && (ln-y5)*c < s*(ln-x5)) {
         x4 = x5 + (ln-y5)*c/s;
         y4 = ln;
         x3 = ln;
         y3 = ln;
      }else if( c>0 && (ln+y5)*c > -s*(ln-x5)) {
         x4 = ln;
         y4 = y5 + (ln-x5)*s/c;
         x3 = ln;
         y3 = -ln;
      }else if( s<0 && c<0 && (ln+y5)*c < s*(ln+x5)) {
         x4 = -ln;
         y4 = y5 - (ln+x5)*s/c;
         x3 = -ln;
         y3 = ln;
      }else {
         x4 = x5 - (ln+y5)*c/s;
         y4 = -ln;
         x3 = -ln;
         y3 = -ln;
      }
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, y5,-x5);
      baseTile.setPoint(2, y4,-x4);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(3)-tiles[0].getX(3);
      offsets[1] = tiles[2].getY(3)-tiles[0].getY(3);
      offsets[2] = tiles[3].getX(3)-tiles[1].getX(3);
      offsets[3] = tiles[3].getY(3)-tiles[1].getY(3);
   }
}