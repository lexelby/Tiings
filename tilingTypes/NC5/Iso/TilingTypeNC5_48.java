package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_48
   extends TilingType
{
   public TilingTypeNC5_48(){
      super( "NC5-48", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,-90,  0,-100};
      paramMax = new int[]{100, 90,100, 100};
      paramDef = new int[]{ 50,  0, 50,  50};
      paramName = new String[]{ "Aspect", "Angle", "Indentation X", "Indentation Y" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,3, 0,3,4, 0},
            {0, 1,0, 0,2,1, 1},
            {0, 4,3, 2,3,4, 1},
      };
      info = "b+d=c\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double height = 1.5 * paramValues[0]/100;
      double width = 1.5 - height;
      double offset = height * Math.tan(paramValues[1] *DEG2RAD);
      double teethx = width * paramValues[2]/100;

      // Get min/max extent of y
      double miny = teethx-offset<width ?  height / (width+offset) * teethx             // to left of top vertex
                                        :  height / (width-offset) * (width*2-teethx);  // to right of top vertex
      double maxy = teethx<offset       ?  height / (width+offset) * (width+teethx)     // to left of top vertex
                                        :  height / (width-offset) * (width-teethx);    // to right of top vertex

      double teethy = ( paramValues[3]<0 ? maxy : miny ) * paramValues[3]/100;

      double x3 = 2*width;
      double y3 = 0;
      double x4 = width+offset;
      double y4 = height;
      double x1 = teethx;
      double y1 = teethy;
      double x2 = x3 - (width-teethx);
      double y2 = y3 - (width-teethx)*teethy/teethx;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(2)-tiles[3].getX(1);
      offsets[3] = tiles[1].getY(2)-tiles[3].getY(1);
   }
}
