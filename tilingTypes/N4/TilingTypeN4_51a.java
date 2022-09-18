package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_51a
   extends TilingType
{
   public TilingTypeN4_51a(){
      super( "N4-51a", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,180,100};
      paramDef = new int[]{ 30, 70, 20};
      paramName = new String[]{ "Side ratio", "Angle", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,3, 0,3,4, 0},

            {1, 0,4, 0,1,2, 0},
            {1, 4,3, 2,3,4, 0},
      };
      info = "b=a+c\nA+B=180\n(C+D=180)";
      labels = new int[]{0,-1,1,2,3};
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.25;
      double w = h;

      double h1 = h * getParam(paramValues,0)/100;
      double h2 = h - h1;

      double c = Math.cos( paramValues[1] * DEG2RAD );
      double s = Math.sin( paramValues[1] * DEG2RAD );
      double os = w * getParam(paramValues,2)/100;

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1,os,  0);
      baseTile.setPoint(2, w,  0);
      baseTile.setPoint(3, w+h1*c, h1*s);
      baseTile.setPoint(4,   h2*c, h2*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(1)-tiles[3].getX(0);
      offsets[3] = tiles[1].getY(1)-tiles[3].getY(0);
   }
}
