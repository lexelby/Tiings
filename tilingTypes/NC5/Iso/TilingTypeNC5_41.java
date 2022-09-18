package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_41
   extends TilingType
{
   public TilingTypeNC5_41(){
      super( "NC5-41", 5, SymmetryType.pg );

      paramMin = new int[]{  0,  0,-100};
      paramMax = new int[]{100,100, 100};
      paramDef = new int[]{ 50, 50,  50};
      paramName = new String[]{ "Aspect", "Indentation X", "Indentation Y" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,0, 0,3,4, 1},
      };
      info = "a=e\nb+d=c\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double height = 1.5 * paramValues[0]/100;
      double width = 1.5 - height;
      double teethx = width * paramValues[1]/100;
      double slope = height/width * paramValues[2]/100;
      double teethy = teethx*slope;

      double x3 = 2*width;
      double y3 = 0;
      double x4 = width;
      double y4 = height;
      double x1 = teethx;
      double y1 = teethy;
      double x2 = x3 - (width-teethx);
      double y2 = y3 - (width-teethx)*slope;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(2)-tiles[0].getX(1);
      offsets[3] = tiles[1].getY(2)-tiles[0].getY(1);
   }
}
